let inputs = require("fs")
  .readFileSync("boj_6987_월드컵.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let answer = [];
  for (var i = 0; i < input.length; i++) {
    let score = 0;
    let arr = input[i].split(" ").map(d => +d);
    let draw = [];
    for (var k = 0; k < arr.length; k += 3) {
      let [w, d, l] = arr.slice(k, k + 3);
      score += w - l;
      if (d !== 0) draw.push(d);
    }

    if (score !== 0) answer.push(0);
    else {
      let set = new Set();
      let visited = new Array(draw.length).fill(0);

      const back = (sum, count) => {
        if (count === draw.length) {
          set.add(sum);
          return;
        } else {
          for (var i = 0; i < draw.length; i++) {
            back(sum + draw[i], count + 1);

            back(sum - draw[i], count + 1);
            // sum += draw[i];
          }
        }
      };

      back(0, 0);
      //   console.log(set);
      if (set.has(0)) {
        answer.push(1);
      } else {
        answer.push(0);
      }
    }

    // console.log(answer);
    // console.log(input[i]);
  }
  console.log(answer.join(" "));
}
solution(inputs);
