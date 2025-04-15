//
// Created by 김규민 on 3/6/24.
//
#include <iostream>

using namespace std;
int n;

bool check(int inp) {
    long long tmp = 6;
    if (inp == 1) {
        return false;
    } else if (inp == 2 || inp == 3) {
        return true;
    } else if (inp % 2 == 0 || inp % 3 == 0) {
        return false;
    } else {
        while (tmp <= inp / 2) {
            if (inp % (tmp + 1) == 0) {
                return false;
            } else if (inp % (tmp - 1) == 0) {
                return false;
            }
            tmp += 6;
        }
    }
    return true;
}

int numbers[4] = {2,3,5,7};

void dfs(int num, int depth) {
    if (depth == n) {
        if (check(num))
            cout << num << endl;
        return ;
    }
    if (!check(num)) {
        return ;
    }
    for (int i = 0; i < 10; ++i) {
        dfs(num * 10 + i, depth + 1);
    }
    return ;
}


int main() {
    cin >> n;

    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 4; ++i) {
        dfs(numbers[i], 1);
    }
//    int a = 0;
//    int b = 1;
//    b = b/10;
//    for (int i = 0; i < n; ++i) {
//        a = a * 10 + 2;
//        b *= 10;
//    }
//    while (a / b <= 10) {
//        int tmp = a;
//        bool flag = true;
//        while (tmp != 0) {
//            if (!check(tmp)) {
//                flag = false;
//                break;
//            }
//            tmp = tmp / 10;
//        }
//        if (flag) {
//            cout << a << endl;
//        }
//        a++;
//    }
}