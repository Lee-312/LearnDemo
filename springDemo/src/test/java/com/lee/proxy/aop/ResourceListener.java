package com.lee.proxy.aop;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceListener {
	private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
	private WatchService ws;
	private String listenerPath;

	public ResourceListener(String listenerPath) {
		try {
			ws = FileSystems.getDefault().newWatchService();
			this.listenerPath = listenerPath;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void start() {
		fixedThreadPool.execute(new Listener(ws, listenerPath));
	}

	public static void addListener(String path) {
		try {
			ResourceListener resourceListener = new ResourceListener(path);
			Path p = Paths.get(path);
			p.register(resourceListener.ws, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
			resourceListener.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Listener implements Runnable {
	WatchService ws;
	String listenerPath;

	Listener(WatchService ws, String listenerPath) {
		this.ws = ws;
		this.listenerPath = listenerPath;
	}

	public void run() {
		try {
			while (true) {
				WatchKey watchKey = this.ws.take();
				List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
				Iterator var4 = watchEvents.iterator();

				while (var4.hasNext()) {
					WatchEvent<?> event = (WatchEvent) var4.next();
					String context = event.context().toString();
					String kind = event.kind().toString();
					if (context.equals("aops.xml") && kind.equals("ENTRY_MODIFY")) {
						XmlReader.readXml(this.listenerPath + "/" + event.context());
					}
				}

				watchKey.reset();
			}
		} catch (InterruptedException var8) {
			var8.printStackTrace();

			try {
				this.ws.close();
			} catch (Exception var7) {
			}

		}
	}
}