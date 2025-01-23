package golang

import (
	"fmt"
	"testing"
)

func TestSlice(t *testing.T) {
	s := make([]int32, 0, 10)
	fmt.Println(len(s))
	fmt.Println(cap(s))
	fmt.Println(s)
	s = append(s, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
	s = append(s, s...)
	fmt.Println(s)
	fmt.Println(len(s))
	fmt.Println(cap(s))

	s1 := s[1:22]
	s1[0] = 100
	fmt.Println(s1)
	fmt.Println(s)
}
