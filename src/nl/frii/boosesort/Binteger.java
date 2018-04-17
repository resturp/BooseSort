/*
Copyright 2018 Thomas Boose

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in 
the Software without restriction, including without limitation the rights to 
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of 
the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all 
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS 
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package nl.frii.boosesort;

/**
 *
 * @author thomas
 */
public class Binteger implements Comparable {

    private int val;
    public static int numberOfCompares = 0;
    
    public Binteger(int value) {
        val = value;
    }

    public int getValue() {
        return val;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.val;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Binteger other = (Binteger) obj;
        if (this.val != other.val) {
            return false;
        }
        return true;
    }

    
    @Override
    public int compareTo(Object o) {
        numberOfCompares++;
        Binteger b = (Binteger)o;
        if (val == b.val ) {
            return 0;
        } else {
            if (val < b.val ) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
