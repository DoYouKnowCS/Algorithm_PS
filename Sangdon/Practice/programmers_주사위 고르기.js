const getCombination = (arr, selectNum) => {
  let result = [];
  if (selectNum === 1) return arr.map(d => [d]);
  arr.forEach((fixed, idx, origin) => {
    let rest = origin.slice(idx + 1);
    let combination = getCombination(rest, selectNum - 1);
    let attached = combination.map(d => [fixed, ...d]);
    result.push(...attached);
  });
  return result;
};

function solution(dice) {
  var answer = [];
  let diceNum = dice.length;
  let max = 0;
  let numArr = new Array(diceNum).fill().map((d, i) => i);
  let combi = getCombination(numArr, diceNum / 2);
  let trash = getCombination([1, 2, 3, 4, 5, 6], 1);
  let combiLen = combi.length;

  const backtracking = (result, arr, depth, map) => {
    let newResult = result;
    if (depth === diceNum / 2) {
      let sum = result.reduce((prev, now) => (prev += now));
      if (map.get(sum)) map.set(sum, map.get(sum) + 1);
      else map.set(sum, 1);
      return;
    }
    for (var z = 0; z < 6; z++) {
      newResult.push(arr[depth][z]);
      backtracking(newResult, arr, depth + 1, map);
      newResult.pop();
    }
  };

  for (var i = 0; i < combiLen; i++) {
    let result = 0;
    let a = combi[i];
    let b = numArr.slice().filter(d => !a.includes(d));
    let aDice = [];
    let bDice = [];
    let aMap = new Map();
    let bMap = new Map();
    a.forEach(data => {
      aDice.push(dice[data]);
    });
    b.forEach(data => {
      bDice.push(dice[data]);
    });
    backtracking([], aDice, 0, aMap);
    backtracking([], bDice, 0, bMap);

    for (var [aVal, aCount] of aMap) {
      for (var [bVal, bCount] of bMap) {
        if (aVal > bVal) result += aCount * bCount;
      }
    }
    if (result > max) {
      max = result;
      let nA = a.map(d => (d += 1));
      answer = nA;
    }
  }
  return answer;
}
