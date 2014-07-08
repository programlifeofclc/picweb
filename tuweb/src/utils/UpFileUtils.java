package utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class UpFileUtils {
	static Random r = new Random();
	
	/**
	 * 不保持比例
	 * @param file
	 * @param path
	 * @param fileName
	 * @param width
	 * @param height
	 * @param outputQuality
	 * @param watermark
	 * @throws IOException
	 */
	public static void NokeepScaleFile(File file,String path,String fileName,int width,int height ,float outputQuality,File watermark) throws IOException{
		int index = fileName.lastIndexOf(".");
		String FileType = fileName.substring(index+1);
		if(!path.endsWith("/")){
			path += path + "/";
		}
		Builder<File> f = Thumbnails.of(file).size(width, height).keepAspectRatio(false).outputQuality(outputQuality).outputFormat(FileType);
		File nf = new File(path + fileName);
		if(!nf.exists()){
			nf.getParentFile().mkdirs();
			nf.createNewFile();
		}
		if(watermark == null){
			f.toFile(nf);
		}else{
			f.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.5f).toFile(nf);
		}
	}
	
	/**
	 * 保持比例的以宽高为基础的图象缩放
	 * @param file 图片
	 * @param path 将要存放路径
	 * @param fileName 文件名
	 * @param width
	 * @param height
	 * @param outputQuality 质量
	 * @param watermark 水印
	 * @throws IOException
	 */
	public static void keepScaleFile(File file,String path,String fileName,int width,int height ,float outputQuality,File watermark) throws IOException{
		int index = fileName.lastIndexOf(".");
		String FileType = fileName.substring(index+1);
		if(!path.endsWith("/")){
			path += path + "/";
		}
		
		
		Builder<File> f = Thumbnails.of(file).size(width, height).outputQuality(outputQuality).outputFormat(FileType);
		File nf = new File(path + fileName);
		if(!nf.exists()){
			nf.getParentFile().mkdirs();
			nf.createNewFile();
		}
		if(watermark == null){
			f.toFile(nf);
		}else{
			f.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.5f).toFile(nf);
		}
	}
	
	
	/**
	 * 保持比例的缩放图片
	 * @param file 图片
	 * @param path 将要存放路径
	 * @param fileName 文件名
	 * @param scale 缩放比例
	 * @param outputQuality 质量 0.0~1.0
	 * @param watermark 水印
	 * @throws IOException 
	 */
	public static void keepScaleFile(File file,String path,String fileName,float scale,float outputQuality,File watermark) throws IOException{
		int index = fileName.lastIndexOf(".");
		String FileType = fileName.substring(index+1);
		if(!path.endsWith("/")){
			path += path + "/";
		}
		Builder<File> f = Thumbnails.of(file).scale(scale).outputQuality(outputQuality).outputFormat(FileType);
		File nf = new File(path + fileName);
		if(!nf.exists()){
			nf.getParentFile().mkdirs();
			nf.createNewFile();
		}
		if(watermark == null){
			f.toFile(nf);
		}else{
			f.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.5f).toFile(nf);
		}
	}
	
	public static String getRanName(){
		String[] az = new String[]{"a","b","c","d","e","f","g"};
		String  imgName = az[r.nextInt(az.length)] + (System.currentTimeMillis()-1404808000000L);
		return imgName;
	}
}
