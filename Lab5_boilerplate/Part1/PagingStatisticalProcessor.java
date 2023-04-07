package Part1;
import java.math.BigInteger;


public class PagingStatisticalProcessor {
    private long physicalMemorySize;
    private long pageSize;
    private int pageOffsetNumOfBits;

    public PagingStatisticalProcessor(long physicalMemorySize, long pageSize, int pageOffsetNumOfBits) {
        super();
        this.physicalMemorySize = physicalMemorySize;
        this.pageSize = pageSize;
        this.pageOffsetNumOfBits = pageOffsetNumOfBits;
    }

    public void PrintStatisticalInformation() {
        long totalPages = physicalMemorySize / pageSize;
        long pageOffsetSize = (long) Math.pow(2, pageOffsetNumOfBits);
        long totalPageOffsetValues = pageOffsetSize * totalPages;
        long totalVirtualMemory = (long) Math.pow(2, 64);
        double virtualToPhysicalMemoryRatio = (double) totalVirtualMemory / physicalMemorySize;

        System.out.println("Total number of pages in physical memory: " + totalPages);
        System.out.println("Total number of unique values that can be represented by the page offset: " + pageOffsetSize);
        System.out.println("Total number of unique page offset values that can be produced by the operating system: " + totalPageOffsetValues);
        System.out.println("Virtual memory to physical memory ratio: " + virtualToPhysicalMemoryRatio);
    }

    public void PrintInformationAboutAProgram(long programSizeInBytes) {
        long totalProgramPages = (long) Math.ceil((double) programSizeInBytes / pageSize);
        long totalPageTableEntries = totalProgramPages + 1;

        System.out.println("Total number of pages required to store the program: " + totalProgramPages);
        System.out.println("Total number of entries in the page table: " + totalPageTableEntries);
    }

    public void PrintInformationAboutAVirtualAddress(String virtualAddress) {
        long virtualAddressInDecimal = Long.parseLong(virtualAddress, 16);
        long pageNumber = virtualAddressInDecimal / pageSize;
        long offset = virtualAddressInDecimal % pageSize;

        System.out.println("The virtual address " + virtualAddress + " contains:");
        System.out.println("Page number: " + pageNumber);
        System.out.println("Offset: " + offset);
    }

}
