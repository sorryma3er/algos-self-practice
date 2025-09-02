"""O(n^2) time complexity && O(1) space complexity"""
def bubble_sort(nums: list[int]) -> list[int]:
    n = len(nums)
    # define unsorted range:
    for i in range(n - 1, 0, -1):
        # inner loop to sort two elt at a time, moving bigger one to the right:
        for j in range(i):
            if nums[j] > nums[j + 1]:
                temp: int = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
    
    return nums

if __name__ == "__main__":
    cases = [
        [64, 34, 25, 12, 22, 11, 90],
        [5, 1, 4, 2, 8],
        [1, 2, 3, 4], # already sorted
        [4, 3, 2, 1], # reverse sorted
        [], # empty list
        [7] # single element
    ]
    
    for arr in cases:
        before = arr[:]
        after = bubble_sort(arr[:]) # sort the copy version since bubble sort is in-place changes to reference type
        print(f"before: {before} -> after: {after}")


            