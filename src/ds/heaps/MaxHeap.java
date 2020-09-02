package ds.heaps;



public class MaxHeap {

	private int[] heap;
	private int maxSize;
	private int size;
	

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new int[maxSize];
		this.size = 0;
	}

	private void swap(int fpos, int spos) {
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}

	private int getParentPos(int pos) {
		return (pos-1)/2;
	}

	public int getMax() {
		return heap[0];
	}

	public int extractMax() {

		int maxValue = this.getMax();

		heap[0] = heap[size-- - 1];
		
		this.heapify(0);

		return maxValue;
	}

	private boolean isLeaf(int pos) {

		if(pos >= size/2 && pos < size) {
			return true;
		}
		return false;
	}

	private int getLeftChild(int pos) {
		if(!isLeaf(pos) && pos <= size-1) {
			return (2*pos)+1;
		}
		return -1;
	}

	private int getRightChild(int pos) {
		if(!isLeaf(pos) && pos <= size-1) {
			return (2*pos)+2;
		}
		return -1;
	}

	public void heapify(int pos) {

		if(this.isLeaf(pos)) {
			return;
		}else {

			int leftChildpos = this.getLeftChild(pos);
			int rightChildpos = this.getRightChild(pos);

			if((leftChildpos <= size-1 &&  heap[pos] < heap[leftChildpos]) || (rightChildpos <= size-1 && heap[pos] < heap[rightChildpos])) {

				if(heap[leftChildpos] < heap[rightChildpos]) {
					this.swap(rightChildpos, pos);
					this.heapify(rightChildpos);
				}else {
					this.swap(leftChildpos, pos);
					this.heapify(leftChildpos);
				}
			}
		}

	}

	public void insert(int element) {

		if(size < maxSize) {
			heap[size++] = element;
			int currPos = size-1;
			int parentPos = getParentPos(currPos);

			while( currPos != parentPos && heap[parentPos] < element) {
				this.swap(currPos, parentPos);
				currPos = parentPos;
				parentPos = getParentPos(currPos);
			}
		}

	}

	private void printHeap() {
		for(int i =0; i< size; i++) {
			System.out.print(heap[i] + " ");
		}
	}


	public static void main(String[] args) {

		MaxHeap heap = new MaxHeap(10);
		heap.insert(8);
		heap.insert(4);
		heap.insert(3);
		heap.insert(5);
		heap.insert(9);
		heap.printHeap();
		System.out.println(" ");
		
		heap.extractMax();
		heap.printHeap();
	}



}
