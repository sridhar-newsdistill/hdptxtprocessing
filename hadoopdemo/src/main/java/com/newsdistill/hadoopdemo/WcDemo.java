package com.newsdistill.hadoopdemo;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WcDemo {

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "Wc");
    job.setJarByClass(com.newsdistill.wordcountdemo.Wc.class);
    job.setMapperClass(com.newsdistill.wordcountdemo.Map.class);

    job.setReducerClass(com.newsdistill.wordcountdemo.Reduce.class);

    // TODO: specify output types
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    // TODO: specify input and output DIRECTORIES (not files)
    FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/usr/local/hadoop/input"));
    FileOutputFormat.setOutputPath(job, new Path("/usr/local/hadoop/out"));

    if (!job.waitForCompletion(true))
      return;
  }

}

