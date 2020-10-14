#include <stdio.h>

// 10763. Á¶ ½Å³ª D5
int main(void)
{
	int T = 0;
	scanf_s("%d", &T);

	for (int t = 1; t < T + 1; t++)
	{
		int N = 0;
		scanf_s("%d", &N);
		
		float chance = 0.;
		for (int n = 1; n < N + 1; n++)
		{
			int punch = 0;
			scanf_s("%d", &punch);

			if (punch != n)
			{
				chance++;
			}
		}

		printf("#%d %.6f\n", t, chance);

	}

	return 0;
}