let inputs = require("fs")
  .readFileSync("boj_1850_최대공약수.txt")
  .toString()
  .trim()
  .split("\n");

let getGCD = (num1, num2) =>
  num1 % num2 > 0 ? getGCD(num2, num1 % num2) : num2;
const makeNumber = num => {
  let str = "";
  for (var i = 0; i < num; i++) {
    str += "1";
  }
  return Number(str);
};
function solution(input) {
  let [a, b] = input[0].split(" ").map(d => BigInt(d));
  let gcd = getGCD(a, b);
  let answer = makeNumber(gcd);
  console.log(answer);
}
solution(inputs);
