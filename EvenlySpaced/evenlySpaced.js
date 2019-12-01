function evenlySpaced(array) {
    if (array.length < 2) return false;
    array.sort();
    var spacing = array[1] - array[0]
    for (i = 2; i < array.length; i++) {
        if (array[i] - spacing != array[i-1]) return false;
    }
    return true;
}
