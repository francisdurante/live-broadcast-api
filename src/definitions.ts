declare module "@capacitor/core" {
  interface PluginRegistry {
    LiveBroadcastPlugin: LiveBroadcastPluginPlugin;
  }
}

export interface LiveBroadcastPluginPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
