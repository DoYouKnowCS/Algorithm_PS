let inputs = require("fs")
  .readFileSync("boj_18310_안테나.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let n = +input[0];
  let house = input[1].split(" ").map(Number);
  house.sort((a, b) => a - b);
  if (n % 2 === 0) {
    let val1 = house[Math.floor((n - 1) / 2)];
    let val2 = house[Math.ceil((n - 1) / 2)];

    let sum1 = 0;
    let sum2 = 0;
    for (var i = 0; i < n; i++) {
      sum1 += Math.abs(house[i] - val1);
      sum2 += Math.abs(house[i] - val2);
    }
    sum1 <= sum2 ? console.log(val1) : console.log(val2);
  } else {
    console.log(house[Math.floor(n / 2)]);
  }

  // 1 2 5 7 9
  // 1 2 5 7
}
solution(inputs);
