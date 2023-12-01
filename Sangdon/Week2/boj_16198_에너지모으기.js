let inputs = require("fs")
  .readFileSync("boj_16198_에너지모으기.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let arrs = input[1].split(" ").map(d => +d);
  let total = 0;
  const re = (arr, sum) => {
    if (arr.length < 3) {
      total = Math.max(total, sum);
      return 0;
    }
    for (var i = 1; i < arr.length - 1; i++) {
      let count = arr[i - 1] * arr[i + 1];
      sum += count;
      let rest = [...arr.slice(0, i), ...arr.slice(i + 1)];
      re(rest, sum);
      sum -= count;
    }
  };
  re(arrs, 0);
  console.log(total);
}
solution(inputs);
