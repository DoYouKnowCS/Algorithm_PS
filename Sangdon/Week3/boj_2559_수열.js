let inputs = require("fs")
  .readFileSync("boj_2559_수열.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let [n, day] = input[0].split(" ").map(d => +d);
  let arr = input[1].split(" ").map(d => +d);
  let ans = -100000001;
  for (var i = 0; i < n - day + 1; i++) {
    let sum = 0;
    let l = i;
    let r = i + day - 1;
    while (l <= r) {
      sum += arr[l];
      l++;
    }
    ans = Math.max(ans, sum);
  }
  console.log(ans);
}
solution(inputs);
