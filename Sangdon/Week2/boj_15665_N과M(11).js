let inputs = require("fs")
  .readFileSync("boj_15665_N과M(11).txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, m] = input[0].split(" ").map(d => +d);
  let answer = [];
  let visited = {};
  let arrs = input[1]
    .split(" ")
    .map(d => +d)
    .sort((a, b) => a - b);
  let set = new Set();
  const re = arr => {
    if (arr.length === m) {
      let str = arr.join(" ");
      if (!set.has(str)) {
        answer.push(str);
        set.add(str);
      }
    } else {
      for (var i = 0; i < arrs.length; i++) {
        re([...arr, arrs[i]]);
      }
    }
  };
  re([]);
  console.log(answer.join("\n"));
}
solution(inputs);
