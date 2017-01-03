// Problem 12.11 - 2d allocation using lesser calls to malloc.
#include<stdio.h>
#include<stdlib.h>
int** my2DAlloc(int rows, int cols){
	int** rowptr = (int**) malloc(rows * sizeof(int*));
	int i;
	for(i = 0; i < rows; i++){
		rowptr[i] = (int *) malloc(cols * sizeof(int));
	}
	return rowptr;
}

void my2DDealloc(int** rowptr, int rows){
	int i;
	for(int i = 0; i < rows; i++){
		free(rowptr[i]);
	}
	free(rowptr);
}

// This method is improved because we have to use less mallocs in our program due to which when we've to free memory we can do that by only 1 free() unlike multiple free's use in previous deallocation.
int** my2DAllocImproved(int rows, int cols){
	int i;
	int head = rows * sizeof(int*);
	int data = rows * cols * sizeof(int);
	int** rowptr = (int**) malloc(head + data);
	if(rowptr == NULL) return NULL;

	int* buf = (int *)(rowptr + rows);
	for(i = 0; i < rows; i++){
		rowptr[i] = buf + i * cols;
	}
	return rowptr;
}
int main(){
	int** arr = my2DAlloc(5, 5);
}
