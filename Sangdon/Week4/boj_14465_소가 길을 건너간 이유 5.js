let inputs = require("fs")
  .readFileSync("boj_14465_소가 길을 건너간 이유 5.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, k, b] = input[0].split(" ").map(d => +d);
  let arr = new Array(n).fill(1);
  let min = 100000;
  let sum = 0;
  for (var i = 1; i < 1 + b; i++) {
    arr[+input[i] - 1] = 0;
  }
  let p1 = 0;
  let p2 = k - 1;
  for (var i = p1; i <= p2; i++) {
    sum += arr[i];
  }
  min = Math.min(min, k - sum);
  while (p2 < arr.length - 1) {
    sum -= arr[p1++];
    sum += arr[++p2];
    min = Math.min(min, k - sum);
  }
  console.log(min);
}
solution(inputs);
