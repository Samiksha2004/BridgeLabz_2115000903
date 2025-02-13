import java.util.*;
class SortStack{ 
        public static void sortStack(Stack<Integer> stack){ 
                if(!stack.isEmpty()){ 
                        int temp = stack.pop();
                        sortStack(stack);
                        insertSorted(stack,temp);
                }
         
        }
        private static void insertSorted(Stack<Integer> stack , int value){ 
                if(stack.isEmpty() ||  stack.peek() <= value){ 
                        stack.push(value);
                        return;
                }
                int temp = stack.pop();
                insertSorted(stack,value);
                stack.push(temp);
        }
        public static void main(String args[]){ 
                Stack<Integer> stack = new Stack<>();
         
                stack.push(3);
                stack.push(4);
                stack.push(2);
                stack.push(1);
         
                sortStack(stack);
                
                while(!stack.isEmpty()){
                        System.out.println(stack.pop() + " ");
                }
        }
}

