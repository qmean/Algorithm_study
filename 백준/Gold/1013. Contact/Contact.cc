#include <iostream>
#include <string>

using namespace std;

string inp;

long long pattern1(string str)
{
    long long size = 0;
    long long size2 = 0;

    if (str.size() < 4)
        return 0;
    if (str[0] == '1' && str[1] == '0')
        size = 2;
    else
        return 0;
    if (str[size] != '0')
        return 0;
    while (size < str.size())
    {
        if (str[size] != '0')
            break;
        size++;
    }
    if (str[size] != '1')
        return 0;
    while (size < str.size())
    {
        if (str[size] != '1')
            break;
        size++;
    }
    if (str[size - 1] == '1' && str[size - 2] == '1')
    {
        size2 = pattern1(str.substr(size - 1));
        if(size2 != 0)
        {
            size = size2 + size - 1;
        }
    }
    return size;
}

long long pattern2(string str)
{
    if (str.size() < 2)
        return 0;
    if (str[0] == '0' && str[1] == '1')
        return 2;
    else
        return 0;
}

void init()
{
    cin >> inp;
    return;
}
void solve()
{
	// 패턴1 : [10(0 * 1+)(1 * 1+)] * 1+
    // 패턴2 : [01] * 1+
    string tmp;
    long long size = 0;
    while (inp.size() != 0)
    {
        if (inp[0] == '0')
        {
            size = pattern2(inp);
            if (size == 0)
            {
                cout << "NO" << '\n';
                return;
            }
            tmp = inp.substr(size, inp.size() - size);
            inp.clear();
            inp = tmp;
        }
        else
        {
            size = pattern1(inp);
            if (size == 0)
            {
                cout << "NO" << '\n';
                return;
            }
            tmp = inp.substr(size, inp.size() - size);
            inp.clear();
            inp = tmp;
        }
    }
    cout << "YES" << '\n';
    return ;
}

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		init();
		solve();
	}
}