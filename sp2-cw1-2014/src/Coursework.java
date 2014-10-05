//@Author Renan Salviato
//@Name SP2 CW1

import java.util.Scanner;

public class Coursework
{
	static int[] array1 = new int[100];
	static int[] array2 = new int[100];
	static int[] commonEl = new int[200];
	static int[] unique1 = new int[100];
	static int[] unique2 = new int[100];
	static int noElArray1 = 0;
	static int noElArray2 = 0;
	static int noCommonEl = 0;
	static int noUniqueEl = 0;

	public static void main(String[] args)
	{
		Coursework test = new Coursework();
		array1 = test.fillArray(1);
		array2 = test.fillArray(2);
		
		if(noElArray1 == 0 && noElArray2 == 0)
		{
			System.out.println("Both arrays are empty.");
		}
		else
		{
			System.out.print(noElArray1 + " Elements in array 1: ");
			displayElements(array1,noElArray1);

			System.out.print(noElArray2 + " Elements in array 2: ");
			displayElements(array2, noElArray2);

			System.out.print("Elements common to both arrays: ");
			displayCommon(array1, array2, noElArray1, noElArray2);
			displayElements(commonEl, noCommonEl);

			System.out.println("No of elements in common: "+noCommonEl);

			System.out.print("Elements unique to array 1: ");
			unique1 = displayUnique(array1, array2, noElArray1, noElArray2);
			displayElements(unique1, noUniqueEl);

			System.out.print("Elements unique to array 2: ");
			unique2 = displayUnique(array2, array1, noElArray2, noElArray1);
			displayElements(unique2, noUniqueEl);
		}
	}

	//Method to populate array
	public int[] fillArray (int number)
	{
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		int[] array = new int[100];

		do
		{
			System.out.println("Please enter an element for array "+number+" (enter 0 to finish):");
			temp = sc.nextInt();

			//if input is not zero, check it doesn't already exist in array
			if(temp != 0)
			{
				for(int i = 0; i<=count; i++)
				{
					if(temp == array[i])
					{
						//if the element is found in array, i=count to exit the loop
						i = count;
					}
					else if(i==count)
					{
						//add element if it's not a zero and it's not in the known array
						array[i] = temp;
						count++;
						i=count;
					}
				}
			}
		} while (temp !=0 && count<100);

		//counting elements going into each array
		if(number == 1)
		{
			noElArray1 = count;
		}
		else
		{
			noElArray2 = count;
		}
		return array;
	}

	//Method to print array until Zero is found
	public static void displayElements (int[] array, int noElArray)
	{
		for (int i = 0; i<noElArray; i++)
		{
			System.out.print(array[i]+" ");
		}

		System.out.println();
	}

	//Method to find common elements
	public static int[] displayCommon (int[] array1, int[]array2, int noElArray1, int noElArray2)
	{
		for (int i = 0; i<noElArray1; i++)
		{
			for (int j = 0; j<noElArray2; j++)
			{
				if(array1[i]==array2[j])
				{
					commonEl[noCommonEl]=array1[i];
					noCommonEl++;
					j = noElArray2;
				}
			}

		}
		return commonEl;
	}

	//Method to find unique elements
	public static int[] displayUnique (int[] array1, int[]array2, int noElArray1, int noElArray2)
	{
		noUniqueEl = 0;
		int[] tempUnique = new int[noElArray1];
		for (int i = 0; i<noElArray1; i++)
		{
			boolean unique = true;
			for (int j = 0; j<noElArray2; j++)
			{
				if(array1[i]==array2[j])
				{
					unique = false;
					j = noElArray2;
				}
			}

			if(unique)
			{
				tempUnique[noUniqueEl]=array1[i];
				noUniqueEl++;
			}
		}
		return tempUnique;
	}
}