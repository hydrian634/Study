var x, left, down;

$("div").mousedown(function (e) {
  e.preventDefault();
  down = true;
  x = e.pageX;
  left = $(this).scrollLeft();
});

$("div").mousemove(function (e) {
  if (down) {
    var newX = e.pageX;
    $("div").scrollLeft(left - newX + x);
  }
});

$("div").mouseup(function (e) {
  down = false;
});
