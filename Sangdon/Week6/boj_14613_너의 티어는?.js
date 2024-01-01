let inputs = require("fs")
  .readFileSync("boj_14613_너의 티어는?.txt")
  .toString()
  .trim()
  .split("\n");

const checkScore = score => {
  if (score >= 1000 && score <= 1499) {
    return 0;
  } else if (score >= 1500 && score <= 1999) {
    return 1;
  } else if (score >= 2000 && score <= 2499) {
    return 2;
  } else if (score >= 2500 && score <= 2999) {
    return 3;
  } else if (score >= 3000 && score <= 3499) {
    return 4;
  }
  return -1;
};

function solution(input) {
  let [wR, lR, dR] = input[0].split(" ").map(Number);
  let rate = new Array(5).fill(0);
  for (var draw = 0; draw <= 20; draw++) {
    let total = 20 - draw;
    let a = Math.pow(dR, draw);
    for (var win = 0; win <= total; win++) {
      let score = 2000;
      let lose = total - win;
      let b = Math.pow(wR, win);
      let c = Math.pow(lR, lose);
      let totalRate = a * b * c;
      let sum = (win - lose) * 50;
      let totalScore = score + sum;
      if (totalRate !== 0) {
        let idx = checkScore(totalScore);
        rate[idx] += totalRate;
      }
    }
  }
  console.log(rate);
}
solution(inputs);
