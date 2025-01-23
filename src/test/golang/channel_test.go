package golang

import (
	"fmt"
	"testing"
	time2 "time"
)

func TestChannel0(t *testing.T) {
	c := make(chan string)
	sendChan(c, time2.Now())
	receiveChan(c)

	select {}
}

func sendChan(c chan string, start time2.Time) {
	go func() {
		for {
			c <- "a"
			if t := time2.Now().UnixNano() - start.UnixNano(); t > 100_000 {
				fmt.Println("will close the chan")
				close(c)
				fmt.Println("closed the chan")
				break
			}
			time2.Sleep(1 * time2.Second)
		}
	}()
}

func receiveChan(c chan string) {
	go func() {
		for {
			v, ok := <-c
			if !ok {
				panic("chan closed")
			}
			println("v is %v", v)
		}
	}()
}

func TestSignal(t *testing.T) {
	signalWithChan()
}

func signalWithChan() {
	c := make(chan int)
	go func() {
		for {
			c <- 1
			fmt.Println("write to chan")
			time2.Sleep(2 * time2.Second)
		}
	}()

	go func() {
		for {
			<-c
			fmt.Println("receive from chan")
		}
	}()

	select {}
}
