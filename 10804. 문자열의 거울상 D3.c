#pragma warning(disable:4996)
#include <stdio.h>
#include <memory.h>

// 10804. 문자열의 거울상 D3
int main(void)
{
	int T = 0;
	scanf("%d", &T);

	for (int t = 1; t < T + 1; t++)
	{
		char cArr[1001];
		char temp[1001];
		scanf("%s", cArr);

		int idx = 0;
		while (cArr[idx] != '\0')
		{
			int in = 999 - idx;
			switch (cArr[idx])
			{
			case 'q':
				temp[in] = 'p';
				break;
			case 'p':
				temp[in] = 'q';
				break;
			case 'b':
				temp[in] = 'd';
				break;
			case 'd':
				temp[in] = 'b';
			default:
				break;
			}
			idx++;
		}
		temp[1000] = '\0';
		char result[1001];
		memcpy(result, &temp[1000 - idx], idx + 1);

		printf("#%d %s\n", t, result);
	}

	return 0;
}