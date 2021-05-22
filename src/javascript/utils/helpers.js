const isEqual = (left, right) => JSON.stringify(left) === JSON.stringify(right);

module.exports = { isEqual };
