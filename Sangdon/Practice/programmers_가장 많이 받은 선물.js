function solution(friends, gifts) {
  var answer = 0;
  let num = friends.length;
  let score = Array.from(Array(num), () => Array(num).fill(0));
  let giftScore = new Array(num).fill(0);
  let giftNum = new Array(num).fill(0);
  gifts.forEach(d => {
    let [giver, receiver] = d.split(" ");
    let giverIdx = friends.indexOf(giver);
    let receiverIdx = friends.indexOf(receiver);
    score[giverIdx][receiverIdx]++;
  });
  for (var i = 0; i < num; i++) {
    let giveScore = score[i].reduce((prev, now) => (prev += now));
    let receiveScore = 0;
    for (var k = 0; k < num; k++) {
      receiveScore += score[k][i];
    }
    // console.log(giveScore, receiveScore)
    giftScore[i] = giveScore - receiveScore;
  }

  score.forEach((d, giver) => {
    d.forEach((data, receiver) => {
      let rNum = score[receiver][giver];
      if (giver !== receiver) {
        if (data === rNum) {
          let aGS = giftScore[giver];
          let bGS = giftScore[receiver];
          if (aGS > bGS) {
            giftNum[giver]++;
          } else if (aGS < bGS) {
            giftNum[receiver]++;
          }
        } else {
          if (data > rNum) {
            giftNum[giver]++;
          } else if (data < rNum) {
            giftNum[receiver]++;
          }
        }
      } else {
      }
    });
  });
  let max = Math.max(...giftNum) / 2;
  return max;
}
