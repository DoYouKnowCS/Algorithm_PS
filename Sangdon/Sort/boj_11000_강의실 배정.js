let inputs = require("fs")
  .readFileSync("boj_11000_강의실 배정.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let n = +input[0];
  let room = 1;
  let arr = [];
  for (var i = 1; i < 1 + n; i++) {
    arr.push(input[i].split(" ").map(d => +d));
  }
  arr.sort((a, b) => a[0] - b[0]);
  let isPlus = false;
  let finishTime = arr[0][1];
  for (var i = 1; i < arr.length; i++) {
    let [s, f] = arr[i];
    if (finishTime > s) {
      room++;
      finishTime = Math.min(f, finishTime);
    } else {
      if (isPlus) {
        finishTime = Math.min(arr[i - 1][1], f);
      } else {
        finishTime = f;
      }
      isPlus = false;
      finishTime = f;
    }
  }
  console.log(room);
}
solution(inputs);
