package BitManipulation;

public class CommonBitTask {
	
	// Get Bit
	boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	// setBit
	int setBit(int num, int i) {
		return (num | (1 << i));
	}
	
	//Clear Bit
	int clearBit(int num, int i) {
		return num & ~(i << i);
	}
	
	//to clear bit from the most significant bit through i (inclusive)
	int clearBitsMSBthroughI(int num, int i) {
		int mask = (i << i) -1;
		return num & mask;
	}
	
	//To clear all bits from i through 0 (inclusive)
	int clearBitsIthrough0(int num, int i) {
		int mask = ~(-1 >> (31 - i));
		return num & mask;
	}
	
	//updata bit 
	int updataBit(int num, int i, int v) {
		return num & ~(1 << i) | (v << i);
	}

}
