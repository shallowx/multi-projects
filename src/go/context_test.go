package go_test

import (
	"context"
	"fmt"
	"testing"
)

func TestContextInit(t *testing.T) {
	ctx := context.Background()
	fmt.Println(ctx)
}
