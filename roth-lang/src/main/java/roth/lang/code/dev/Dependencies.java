package roth.lang.code.dev;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import roth.lang.Map;
import roth.lang.Set;

public class Dependencies
{
	protected File jdkDir;
	protected Set<File> javaJarFiles = new Set<>();
	protected Map<String, Dependency> javaDependencyMap = new Map<>();
	
	public Dependencies()
	{
		
	}
	
	public File getJdkDir()
	{
		return jdkDir;
	}
	
	public File getJreDir()
	{
		return new File(jdkDir, "jre");
	}
	
	public Set<File> getJreJarFiles()
	{
		return getJarFiles(getJreDir());
	}
	
	public Set<File> getJavaJarFiles()
	{
		return javaJarFiles;
	}
	
	public Set<File> getAllJarFiles()
	{
		return new Set<File>().collection(getJreJarFiles()).collection(getJavaJarFiles());
	}
	
	public Dependencies setJdkDir(File jdkDir)
	{
		this.jdkDir = jdkDir;
		return this;
	}
	
	public Dependencies setJavaJarFiles(Set<File> classpathJarFiles)
	{
		this.javaJarFiles = classpathJarFiles;
		return this;
	}
	
	public Dependencies addJavaJarFiles(File...javaJarFiles)
	{
		this.javaJarFiles.array(javaJarFiles);
		return this;
	}
	
	public static Set<File> getJarFiles(File dir)
	{
		Set<File> jarFiles = new Set<File>();
		for(File file : dir.listFiles())
		{
			if(file.isDirectory())
			{
				jarFiles.addAll(getJarFiles(file));
			}
			else if(file.isFile() && file.getName().endsWith(".jar"))
			{
				jarFiles.add(file);
			}
		}
		return jarFiles;
	}
	
	public Dependencies load()
	{
		try(JarClassLoader jarClassLoader = new JarClassLoader(getAllJarFiles());)
		{
			for(Entry<File, Set<Class<?>>> jarFileClassesEntry : jarClassLoader.getJarFileClassesMap().entrySet())
			{
				File jarFile = jarFileClassesEntry.getKey();
				String name = jarFile.getName();
				Dependency dependency = javaDependencyMap.get(name);
				if(dependency != null)
				{
					if(jarFile.hashCode() != dependency.getHashCode())
					{
						dependency = null;
					}
				}
				if(dependency == null)
				{
					javaDependencyMap.put(name, new Dependency(jarFile, jarFileClassesEntry.getValue()));
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	public static void main(String[] args)
	{
		File jdkDir = new File("C:\\Program Files\\Java\\jdk1.8.0_112");
		Dependencies dependencies = new Dependencies().setJdkDir(jdkDir);
		dependencies.load();
	}
	
}
