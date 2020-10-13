class Solution {
    public int[] shortestToChar(String S, char C) {
        int str_l = S.length();
        int[] f =new int[str_l];
        String l;
        int m=0;
        while (S.length()>0) {
            if (S.charAt(0)==C) {
                l = Character.toString(C);;
                f[m] = 0;
                m++;
                if(S.length()>1) {
                    S = S.substring(S.indexOf(C)+1);
                } else {
                    S="";
                }
            } else {
                if (S.indexOf(C)>=0) {
                    l = S.substring(0, S.indexOf(C));
                    S = S.substring(S.indexOf(C));
                } else {
                    l=S;
                    S="";
                }
                int[] a=distance(l);
                if (m==0) {
                    for (int x=l.length();x>0;x--) {
                        f[m] = x;
                        m++;
                    }
                } else if (m+l.length() == str_l) {
                    for (int x=1; x<=l.length(); x++) {
                        f[m] = x;
                        m++;
                    }
                } else {
                    for (int x:a) {
                        f[m] = x;
                        m++;
                    }
                }
            }
        }
        return f;
    }
    public static int[] distance(String s) {
        int[] arr= new int[s.length()];
        int l=0;
        if (s.length()%2==0) {
            l=(int)Math.floor(s.length()/2);
            
        } else {
            l=(int)Math.floor(s.length()/2)+1;
        }
        for (int i=0; i<s.length();i++) {
            if (i<l) {
                arr[i] = i+1;
            } else {
                if (s.length()%2==0) {
                    arr[i]=s.length()-i;

                } else {
                    arr[i]=s.length()%i;
                }
            }
        }
        return arr;
    }
}
