package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import util.FileUtil;

public class SplitFile {
	//分割文件路径
	private String filePath;
	//文件大小
	private long length;
	//文件名
	private String name;
	//块数
	private int size;
	//每块大小
	private long blockSize;
	//每块名称
	private List<String> blockName;
	public SplitFile() {
		blockName = new ArrayList<String>();
	}
	public SplitFile(String filePath) {
		this(filePath,1204);
	}
	
	public SplitFile(String filePath,long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}
	public void init() {
		File src = null;
		if (null == filePath||!((src = new File(filePath)).exists())) {
			return;
		}
		if(src.isDirectory()) {
			return;

		}
		this.name = src.getName();
		this.length = src.length();
		if(this.blockSize>length) {
			this.blockSize = length;
		}
		size = (int)Math.ceil(length*1.0/this.blockSize);
		
	}
	private void initPathName(String destPath) {
		for(int i = 0;i<=size;i++) {
			this.blockName.add(destPath+"/"+this.name+".part"+i);
		}
	}
	public void spilt(String destPath) {
		//确定文件路径
		initPathName(destPath);
		long beginPos = 0;
		long actualBlockSize = blockSize;
		
		for(int i = 0;i < size;i++) {
			if(i==size-1) {
				actualBlockSize = this.length - beginPos;
			}
			spiltDetail(i,beginPos,actualBlockSize);
			beginPos += actualBlockSize;
		}
	}
	private void spiltDetail(int idx,long beginPos,long actualBlockSize) {
		File src = new File(this.filePath);
		File dest = new File(this.blockName.get(idx));
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src,"r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			raf.seek(beginPos);
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1!=(len=raf.read(flush))) {
				if(actualBlockSize-len>=0) {
					bos.write(flush,0,len);
					actualBlockSize -= len;
				}else {
					bos.write(flush, 0, (int)actualBlockSize);
					break;
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			FileUtil.close(bos,raf);
		}
		
	}
	public  void mergeFile(String destPath) {
		File dest = new File(destPath);
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));
			BufferedInputStream bis = null;
			for(int i = 0;i < blockName.size();i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockName.get(i))));
				
				byte[] flush = new byte[1024];
				int len = 0;
				while(-1!=(len=bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				FileUtil.close(bis);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			FileUtil.close(bos);
		}
	
		
	}
	public static void main(String[] args) {
		SplitFile file = new SplitFile("D:/学习工作/dyx/11/3.java",500);
		//System.out.println(file.size);
		//file.spilt("D:/学习工作/dyx/11");
		file.mergeFile("D:/学习工作/dyx/11/5.java");
	}
} 
