def selection_sort(array: list) -> list:
    """Selection Sort. Return sorted list"""
    for i in range(len(array) - 1):
        min_ind = i
        for j in range(i, len(array)):
            if array[min_ind] > array[j]:
                min_ind = j
        array[i], array[min_ind] = array[min_ind], array[i]
    return array
