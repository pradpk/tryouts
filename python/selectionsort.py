#bubble sort accumulates at right side, selection sort accumulates at left side
#performs with O(n^2)
def selectionsort(arr):
	print(arr)
	for i in range(len(arr)):
		#min index will be the leftmost of the iteration
		min = i
		for j in range(i+1, len(arr)):
			if arr[j] < arr[min]:
				#At the end of iteration, min index will have the most minimum value
				min = j
			else:
				pass
		#since left most doesn't contain minimum, we will swap the minimum to leftmost
		if min != i:
			tmp = arr[min]
			arr[min] = arr[i]
			arr[i] = tmp
	print(arr)
	

arr = [7,3,2,1,4]
selectionsort(arr)
