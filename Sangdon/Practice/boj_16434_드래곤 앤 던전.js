let inputs = require("fs")
  .readFileSync("boj_16434_드래곤 앤 던전.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let [n, hATK] = input[0].split(" ").map(d => +d);
  let maxHp = 0;
  for (var i = 1; i < 1 + n; i++) {
    let [t, a, h] = input[i].split(" ").map(d => +d);
    if (t === 1) {
      maxHp += a * Math.ceil((h - 1) / hATK);
    } else {
      hATK += a;
      maxHp -= h;
    }
  }
  console.log(maxHp + 1);
}
solution(inputs);
