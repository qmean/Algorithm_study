#include <iostream>
#include <string>

using namespace std;

int main()
{
    int n;
    cin>>n;
    int a[2][26];//알파벳 개수 비교용
    int b=0;//판별용
    
    for(int i=0; i<26; i++){
            a[0][i]=0;
            a[1][i]=0;
    }//알파벳 개수 0으로 초기화
    
    string ar[2][n];//2개의 문자열
    string bo[n];//possible or impossible
    
    for(int i=0; i<n; i++){
        cin>>ar[0][i]>>ar[1][i];
    }//문자열 모두 입력
    
    for(int i=0; i<n; i++){
        b=0;//0으로 다시 초기화
        for(int j=0; j<ar[0][i].size(); j++){
            a[0][ar[0][i].at(j)-97]++;
        }
        for(int j=0; j<ar[1][i].size(); j++){
            a[1][ar[1][i].at(j)-97]++;
        }//알파벳 개수 채워넣기
        for(int j=0; j<26; j++){
            if(a[0][j]!=a[1][j]){
                b++;
            }
        }//b로 알파벳 개수 맞는지 확인(0이면 같고 1이상이면 다르다)
        if(b==0){
            bo[i]="Possible";
        }
        else{
             bo[i]="Impossible";
        }
        //possible or impossible결정
        for(int j=0; j<26; j++){
            a[0][j]=0;
            a[1][j]=0;
        }//알파벳 개수 0으로 초기화
        
    }
    
    for(int i=0; i<n; i++){
        cout<<bo[i]<<"\n";
    }
    

    return 0;
}
