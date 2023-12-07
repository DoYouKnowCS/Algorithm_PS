let inputs = require("fs")
  .readFileSync("boj_1865_부분합.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, s] = input[0].split(" ").map(d => +d);
  let arr = input[1].split(" ").map(d => +d);
  let ans = Infinity;
  let l = (r = sum = 0);
  while (l <= r) {
    if (sum >= s) {
      ans = Math.min(ans, r - l);
      sum -= arr[l];
      l++;
    } else if (r === n) {
      break;
    } else {
      sum += arr[r];
      r++;
    }
  }
  if (ans != Infinity) console.log(ans);
  else {
    console.log(0);
  }
}

solution(inputs);
