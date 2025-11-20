//Processes the stack using the given arithmetic rules:
//- If both popped numbers are odd → add them
//- If both are even → multiply them
//- If one is odd and one is even → take absolute difference
//The process continues until only one number remains.

//The stack of integers to process and return the final remaining number after all operations
public static int processStack(Stack<Integer> stack)
{
    // To label each operation step
    int step = 1;

    // Continue until only one element is left
    while (stack.size() > 1)
    {

        // Pop the top two numbers from the stack
        int num1 = stack.pop();
        int num2 = stack.pop();

        IO.println("Step " + step + ":");
        IO.println("  Popped: " + num1 + ", " + num2);

        int result; //Creating empty box named result
        String operation;

        // CASE 1: Both numbers are odd
        if (num1 % 2 == 1 && num2 % 2 == 1)
        {
            result = num1 + num2;
            operation = num1 + " + " + num2 + " = " + result;

            // CASE 2: Both numbers are even
        } else if (num1 % 2 == 0 && num2 % 2 == 0)
        {
            result = num1 * num2;
            operation = num1 + " × " + num2 + " = " + result;

            // CASE 3: One odd, one even → absolute difference
        } else
        {
            result = Math.abs(num1 - num2);
            operation = "|" + num1 + " - " + num2 + "| = " + result;
        }

        IO.println("  Operation: " + operation);

        // Push the resulting value back onto the stack
        stack.push(result);
        IO.println("  Stack after operation: " + stack);
        IO.println();

        step++;
    }

    // Final number in the stack is the final result
    return stack.pop();
}

        void main()
        {

            // Student ID (digits only part)
            String studentIdDigits = "00019245";

            // Create a stack to hold the numeric digits of the student ID
            Stack<Integer> stack = new Stack<>();

            // Push each digit into the stack (left to right)
            for (int i = 0; i < studentIdDigits.length(); i++)
            {
                char digitChar = studentIdDigits.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                stack.push(digit);
            }

            IO.println("Student ID: A00019245");
            IO.println("Numeric digits: " + studentIdDigits);
            IO.println("Initial stack: " + stack);
            IO.println("\nStarting operations:\n");

            // Process the stack using defined arithmetic rules
            //Calling the Method
            int result = processStack(stack);

            // Print the final remaining number
            IO.println("Final result: " + result);
        }