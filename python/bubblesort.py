#Bubble sort is very slow (O(n^2)), but simplest of the sorting.
#Rule
#For below list, it will take elements from index 0 and 1, if the order is not right, swaps them.
#Above step continues till it pushes the index 0 to the right place. In below case, 7 will be moved to rightmost place.
#Since the rightmost element is sorted, it will not be considered in next sort operation.

def bubble(arr):
	for i in range(len(arr)-1, -1, -1):
		for j in range(i+1):
			if j+1<len(arr) and arr[j] > arr[j+1]:
				tmp = arr[j+1]
				arr[j+1] = arr[j]
				arr[j] = tmp
	print(arr)
	
	
arr = [7,3,2,1,4]
bubble(arr)
