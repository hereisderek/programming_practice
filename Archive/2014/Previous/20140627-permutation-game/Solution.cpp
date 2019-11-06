#include<iostream>
#include<set>
using namespace std;

#define set(a,i)  a|1<<i
#define unset(a,i) ((a)&(~(1<<i)))

int array[32770];

int permu(int a[],int n,int r);
int get1(int a,int i)
{
    return ((a&(1<<i))>>i);
}

int main()
{

int T;
cin>>T;

while(T--)
{
    for(int i=0;i<32768;i++)
        array[i]=-1;

    int n;
    cin>>n;
    int a[n];

    for(int i=0;i<n;i++)
        cin>>a[i];

    int res=permu(a,n,(1<<n)-1);
    if(res==0)
        cout<<"Bob\n";
    else
        cout<<"Alice\n";

}

}

int permu(int a[],int n,int r)
{

    if(array[r]!=-1)
        return array[r];

    int last=0,i;
    for(i=0;i<n;i++)
    {
        if(get1(r,i)==1)
        {
            if(a[i]>last)
            last=a[i];
            else
            break;
        }
    }

    if(i==n)
    {
        array[r]=0;
        return 0;
    }

    set<int> s;

    for(int i=0;i<n;i++)
    {
        if(get1(r,i)==1)
        {
            s.insert(permu(a,n,unset(r,i)));
        }

    }

    set<int>::iterator iter;
    iter=s.begin();
    if(*iter==1)
        array[r]=0;
    else
        array[r]=1;

    return array[r];

}
