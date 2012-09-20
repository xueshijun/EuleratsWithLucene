(*
** HX: turning JD price images into numbers
*)

(* ****** ****** *)

#define ATS_DYNLOADFLAG 0

(* ****** ****** *)

staload STDIO = "libc/SATS/stdio.sats"
staload STDLIB = "libc/SATS/stdlib.sats"

(* ****** ****** *)

fun pnumbase
  (id: string): string = let
  val str = sprintf ("/tmp/gp%s", @(id))
in
  string_of_strptr (str)
end // end of [pnumbase]

fun pimgname
  (id: string): string = let
  val str = sprintf ("/tmp/gp%s.png", @(id))
in
  string_of_strptr (str)
end // end of [pimgname]

fun wgetCommand
  (id: string, imgfile: string): string = let
  val command = sprintf (
    "wget --quiet --output-document=%s http://price.360buyimg.com/gp%s,3.png", @(imgfile, id)
  ) // end of [val]
in
  string_of_strptr (command)
end // end of [pimgname]

fun tesseractCommand
  (imgfile: string, numbase: string): string = let
  val command = sprintf ("tesseract %s %s", @(imgfile, numbase))
in
  string_of_strptr (command)
end // end of [tesseractCommand]

(* ****** ****** *)

extern
fun JDpimg2num (id: string): string = "ext#JDpimg2num"

implement
JDpimg2num (id) = let
//
val imgfile = pimgname (id)
val numbase = pnumbase (id)
//
val cmd =
  wgetCommand (id, imgfile)
val err = $STDLIB.system (cmd)
//
var res: string = ""
//
val isemp = test_file_isemp (imgfile)
val () =
  if isemp <= 0 then let
  val err = $STDLIB.system (tesseractCommand (imgfile, numbase))
in
//
if err = 0 then let
  val numfile =
    sprintf ("%s.txt", @(numbase))
  val numfile = string_of_strptr (numfile)
  val filr = open_file_exn (numfile, file_mode_r)
  val line = input_line (filr)
  val () = close_file_exn (filr)
  val err = $STDIO.remove_err (numfile)
in
  if stropt_is_some (line) then res := stropt_unsome (line)
end else () // end of [if]
end // end of [val]
//
in
  res
end // end of [JDpimg2num]

(* ****** ****** *)

#if defined(_AS_COMMAND)
//
implement
main (argc, argv) = let
//
val id = "0"
var id: string = id
val () = if argc >= 2 then id := argv.[1]
//
val num = JDpimg2num (id)
//
val () = println! ("ID = ", id)
val () = println! ("JDprice = ", num)
//
in
  // nothing
end // end of [main]
//
#endif

(* ****** ****** *)

(* end of [JDpimg2num.dats] *)
