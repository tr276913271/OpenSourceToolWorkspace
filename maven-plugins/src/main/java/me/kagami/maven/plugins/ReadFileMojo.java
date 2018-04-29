package me.kagami.maven.plugins;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "readfile")
public class ReadFileMojo extends AbstractMojo {
	@Parameter(defaultValue = "${project.basedir}/src/main/resources/generatorConfig.xml", required = true)
	private File configurationFile;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println(configurationFile.exists());

	}

}
