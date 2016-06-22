// HW7: Data Mining Extra Credit
//Addison Dunn: awd5eg, Audrey Fifer:
//Edwards

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.util.logging.FileHandler;

import weka.*;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class Main
{
	final static String FILE_NAME = "irisData.txt";
	
	public static void main(String[] args) throws Exception
	{
		FileInputStream fin = new FileInputStream(FILE_NAME);
	    InputStreamReader istream = new InputStreamReader(fin);
	    BufferedReader stdin = new BufferedReader(istream);
	    
	    
	    File f = new File("./training.txt");
	    f.delete();
	    f = new File("./testing.txt");
	    f.delete();
	    f = new File("./training.csv");
	    f.delete();
	    f = new File("./testing.csv");
	    f.delete();
	    
	    FileWriter fw = new FileWriter("./training.txt");	    
	    FileWriter fw2 = new FileWriter("./testing.txt");
	    
	    String line = stdin.readLine();
	    
	    int numCommas = 1;
	    for(int x = 0; x<line.length(); x++)
	    	if(line.substring(x,x+1).equals(","))
	    		numCommas++;
	    for(int x = 1; x<numCommas; x++) {
	    	fw.write("c"+x+",");
	    }
	    fw.write("c"+numCommas+"\n");
	    for(int x = 1; x<numCommas; x++) {
	    	fw2.write("c"+x+",");
	    }
	    fw2.write("c"+numCommas+"\n");
	    
	    int count = 1;
	    while(line != null) {
	    	if(count % 5 ==0) {
	    		fw2.write(line + "\n");
	    	}
	    	else
	    		fw.write(line + "\n");
	    	line = stdin.readLine();
	    	count++;
	    }
	    fw.close();
	    fw2.close();
	    
	    File txtFile = new File( "training.txt" ) ;
	    File csvFile = new File( "training.csv" ) ;
	    txtFile.renameTo( csvFile ) ;
	    
	    File txtFile1 = new File( "testing.txt" ) ;
	    File csvFile1 = new File( "testing.csv" ) ;
	    txtFile1.renameTo( csvFile1 ) ;
		//
	    
	    DataSource source = new DataSource("training.csv");
	    Instances train = source.getDataSet();
	    // setting class attribute if the data format does not provide this information
	    // For example, the XRFF format saves the class attribute information as well
	    if (train.classIndex() == -1)
	      train.setClassIndex(train.numAttributes() - 1);
	    
	    DataSource source2 = new DataSource("testing.csv");
	    Instances test = source2.getDataSet();
	    // setting class attribute if the data format does not provide this information
	    // For example, the XRFF format saves the class attribute information as well
	    if (test.classIndex() == -1)
	      test.setClassIndex(test.numAttributes() - 1);
	    
	    //String[] options = new String[2];
	    Remove rm = new Remove();                         // new instance of filter
	    //rm.setOptions(options);                           // set options
	    rm.setInputFormat(train);                          // inform filter about dataset **AFTER** setting options
	    Instances newData = Filter.useFilter(train, rm);   // apply filter
	    
	    rm.setAttributeIndices("1");  // remove 1st attribute
	    // classifier
	    J48 j48 = new J48();
	    j48.setUnpruned(true);        // using an unpruned J48
	    // meta-classifier
	    FilteredClassifier fc = new FilteredClassifier();
	    fc.setFilter(rm);
	    fc.setClassifier(j48);
	    // train and make predictions
	    fc.buildClassifier(train);
	    Evaluation eval=new Evaluation(train);
	    eval.crossValidateModel(j48, train, 5, new Random(1));
	    for (int i = 0; i < test.numInstances(); i++) {
	      double pred = fc.classifyInstance(test.instance(i));
	      System.out.print("ID: " + test.instance(i).value(0));
	      System.out.print(", actual: " + test.classAttribute().value((int) test.instance(i).classValue()));
	      System.out.println(", predicted: " + test.classAttribute().value((int) pred));
	    }
	    System.out.println(j48.toString());
	    //System.out.print(j48.graph());

	}
}