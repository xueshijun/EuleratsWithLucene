(*
** HX: filling-in JD price
*)

(* ****** ****** *)

staload UN = "prelude/SATS/unsafe.sats"
staload _(*anon*) = "prelude/DATS/reference.dats"

(* ****** ****** *)

staload STR = "libc/SATS/string.sats"

(* ****** ****** *)

extern
fun fprint_ctime (out: FILEref): void

local

staload "libc/SATS/time.sats"

in // in of [local]

implement
fprint_ctime
  (out) = let
  var t
    : time_t = time_get ()
  val (fpf_x | x) = ctime (t)
  val () = fprint_strptr (out, x)
  prval () = fpf_x (x)
in
  // nothing
end // end of [fprint_ctime]

end // end of [local]

(* ****** ****** *)

extern
fun string_of_prefix
  (str: string, prfx: string): bool
// end of [string_of_prefix]

implement
string_of_prefix
  (str, prfx) = let
  val prfx =
    string1_of_string (prfx)
  val n = $STR.strlen (prfx) in $STR.strncmp (str, prfx, n) = 0
end // end of [string_of_prefix]

(* ****** ****** *)

extern fun prefixget_ID (OUT: FILEref): strptr0
extern fun prefixget_URL (OUT: FILEref): strptr0
extern fun prefixget_title (OUT: FILEref): strptr0
extern fun prefixget_JDprice (OUT: FILEref): strptr0
extern fun prefixget_JDpprice (OUT: FILEref): strptr0
extern fun prefixget_JDmprice (OUT: FILEref): strptr0

(* ****** ****** *)

extern
fun prefixget (inp: FILEref, prfx: string): strptr0
implement
prefixget (inp, prfx) = let
  val line = input_line_vt (inp)
in
  if strptr_isnot_null (line) then let
    val test = string_of_prefix ($UN.castvwtp1{string}{strptr1}(line), prfx)
  in
    if test then line else let
      val () =
        fprint_strptr (stdout_ref, line)
      val () = fprint_newline (stdout_ref)
      val () = strptr_free (line)
    in
      prefixget (inp, prfx)
    end // end of [if]
  end else line // end of [if]
end // end of [prefixget]

implement prefixget_ID (inp) = prefixget (inp, "ID")
implement prefixget_URL (inp) = prefixget (inp, "URL")
implement prefixget_title (inp) = prefixget (inp, "title")
implement prefixget_JDprice (inp) = prefixget (inp, "JDprice")
implement prefixget_JDpprice (inp) = prefixget (inp, "JDpprice")
implement prefixget_JDmprice (inp) = prefixget (inp, "JDmprice")

(* ****** ****** *)

fun itemid_test
  (id: string): bool = let
//
val id = string1_of_string (id)
//
fun loop
  {n,i:nat | i <= n} .<n-i>.
  (id: string n, i: size_t i): bool =
  if string_isnot_atend (id, i) then (
    if char_isdigit (id[i]) then loop (id, i+1) else false
  ) else (
    true
  ) // end of [if]
//
in
  loop (id, 0)
end // end of [itemid_test]

(* ****** ****** *)

extern
fun JDpimg2num (id: string): string = "ext#JDpimg2num"

(* ****** ****** *)

extern
fun process_one (inp: FILEref, cnt: int): int
extern
fun process_id_one (inp: FILEref, id: string, cnt: int): int

local

fun aux
  (p0: string): string = let
  val p = $STR.strchr (p0, (int_of_char)'=')
  val () = assertloc (p > null)
  val p = p + 1
  val n = $STR.strspn ($UN.cast{String}(p), " ")
in
  $UN.cast{string}(p+n)
end // end of [aux]

in // in of [local]

implement
process_one (inp, cnt) = let
//
val id = prefixget_ID (inp)
val test = strptr_isnot_null (id)
in
//
if test then let
  val id2 =
    $UN.castvwtp1{string}(id)
  val () =
    fprint_string (stdout_ref, id2)
  val () = fprint_newline (stdout_ref)
  val id2 = aux (id2)
  val test = itemid_test (id2)
  val ret = (
    if test then process_id_one (inp, id2, cnt) else 1
  ) : int // end of [val]
  val () = strptr_free (id)
in
  ret
end else let
  val () = strptr_free (id) in 0(*break*)
end // end of [if]
//
end // end of [process_one]

implement
process_id_one
  (inp, id, cnt) = let
//
val price =
  prefixget_JDprice (inp)
val test = strptr_isnot_null (price)
//
in
//
if test then let
  val () = strptr_free (price)
  val price2 = JDpimg2num (id)
  val () = fprintf (stdout_ref, "JDprice = %s", @(price2))
  val () = fprint_newline (stdout_ref)
in
  1(*cont*)
end else let
  val () = strptr_free (price) in 0(*break*)
end // end of [if]
//
end // end of [process_id_one]

end // end of [local]

(* ****** ****** *)

staload STDIO = "libc/SATS/stdio.sats"

(* ****** ****** *)

extern
fun process_many
  (inp: FILEref, cnt: int): void
implement
process_many
  (inp, cnt) = let
  val out = stdout_ref
  val ret = process_one (inp, cnt)
in
  if ret > 0 then let
    val cnt1 = cnt + 1
    val () = if
      (cnt1 mod 100 = 0) then (
      fprint (out, "**JDpricefill**: "); fprint_ctime (out)
    ) // end of [if] // end of [val]
  in
    process_many (inp, cnt1)
  end else ()
end // end of [process_many]

(* ****** ****** *)

implement
main (argc, argv) = let
//
val () = process_many (stdin_ref, 0)
//
in
  // nothing
end // end of [main]

(* ****** ****** *)

(* end of [JDpricefill.dats] *)
