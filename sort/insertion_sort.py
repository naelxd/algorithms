def insertion_sort(array: list) -> list:
    """Insertion Sort algorithm. Return sorted list"""
    for j in range(1, len(array)):
        key = array[j]
        i = j - 1
        while i >= 0 and key < array[i]:
            array[i + 1] = array[i]
            i -= 1
        array[i+1] = key
    return array
