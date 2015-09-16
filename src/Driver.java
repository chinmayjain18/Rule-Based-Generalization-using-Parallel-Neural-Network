import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.RBFNetwork;
import weka.core.Instances;
 
public class Driver {
 
    public static void main(String[] args) throws Exception{
         
    	Converter tdta = new Converter();
    	Instances dataset = tdta.createDataset();
    	dataset.setClassIndex(dataset.numAttributes() - 1);
        Classifier cModel = (Classifier)new RBFNetwork();   
        cModel.buildClassifier(dataset);
 
         // Test the model
         Evaluation eTest = new Evaluation(dataset);
         eTest.evaluateModel(cModel, dataset);
          
         // Print the result à la Weka explorer:
         String strSummary = eTest.toSummaryString();
         System.out.println(strSummary);
          
         // Get the confusion matrix
         double[][] cmMatrix = eTest.confusionMatrix();
         for(int row_i=0; row_i<cmMatrix.length; row_i++){
             for(int col_i=0; col_i<cmMatrix.length; col_i++){
                 System.out.print(cmMatrix[row_i][col_i]);
                 System.out.print("|");
             }
             System.out.println();
         }
    }
}