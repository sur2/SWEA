#include <stdio.h>
// 7854. ÃÖ¾à¼ö D4
int main(void)
{
	int arr[48] = { 0, };

	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 5;

	arr[4] = 10;
	arr[5] = 20;
	arr[6] = 25;
	arr[7] = 50;

	arr[8] = 100;
	arr[9] = 125;
	arr[10] = 200;
	arr[11] = 250;
	arr[12] = 500;

	for (int i = 13; i < 42; i += 5) {
		arr[i] = arr[i - 5] * 10;
		arr[i + 1] = arr[i - 4] * 10;
		arr[i + 2] = arr[i - 3] * 10;
		arr[i + 3] = arr[i - 2] * 10;
		arr[i + 4] = arr[i - 1] * 10;
	}

	arr[43] = 1000000000;

	int T = 0;
	scanf_s("%d", &T);
	
	int X = 0;
	int index = 0;
	for (int t = 1; t < T + 1; t++)
	{
		scanf_s("%d", &X);

		index = 43;
		while (arr[index] > X)
		{
			index--;
		}

		printf_s("#%d %d\n", t, index);
	}

	return 0;
}