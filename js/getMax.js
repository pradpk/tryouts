const x = [12,45,32,34];

function getMax(arr) {
  let max = -Infinity;
  arr.forEach(function (number) {
    max = Math.max(max, number);
  })
  return max;
}

console.log(getMax(x));
