let inputs = require("fs")
  .readFileSync("boj_14719_빗물.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let answer = 0;
  let [n, m] = input[0].split(" ").map(d => +d);
  let height = input[1].split(" ").map(d => +d);
  let board = Array.from(Array(n), () => new Array(m).fill(0));

  height.forEach((data, idx) => {
    for (var k = n - 1; k > n - data - 1; k--) {
      board[k][idx] = 1;
    }
  });

  for (var i = n - 1; i >= 0; i--) {
    let arr = board[i];
    let count = 0;
    let idxOne = [];

    arr.forEach((d, idx) => (d === 1 ? idxOne.push(idx) : null));

    for (var k = 0; k < idxOne.length - 1; k++) {
      let prev = idxOne[k];
      let next = idxOne[k + 1];
      count += next - prev - 1;
    }
    answer += count;
  }
  console.log(answer);
}
solution(inputs);
