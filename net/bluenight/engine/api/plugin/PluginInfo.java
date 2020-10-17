package net.bluenight.engine.api.plugin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.bluenight.engine.api.plugin.exception.InvalidPluginException;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author AdvancedAntiSkid
 */
public class PluginInfo
{
    public final String main;
    public final String name;
    public final String version;
    public final String author;
    public final String description;

    private PluginInfo(String main, String name, String version, String author, String description)
    {
        this.main = main;
        this.name = name;
        this.version = version;
        this.author = author;
        this.description = description;
    }

    public static PluginInfo load(File file)
    {
        try
        {
            PluginInfo info = find(file);
            if(info == null)
                throw new InvalidPluginException("No plugin.json found");
            return info;
        }
        catch (Exception e)
        {
            throw new InvalidPluginException(e);
        }
    }

    public static PluginInfo find(File file) throws IOException
    {
        JarFile jar = new JarFile(file);
        Enumeration<JarEntry> entries = jar.entries();
        while(entries.hasMoreElements())
        {
            JarEntry entry = entries.nextElement();
            if(entry.getName().endsWith("plugin.json"))
            {
                JarEntry fileEntry = jar.getJarEntry(entry.getName());
                return parse(jar.getInputStream(fileEntry));
            }
        }
        return null;
    }

    private static PluginInfo parse(InputStream inputStream) throws IOException
    {
        JsonObject json = JsonParser.parseString(read(inputStream)).getAsJsonObject();

        String main = json.get("main").getAsString();
        String name = json.get("name").getAsString();
        String version = json.get("version").getAsString();
        String author = json.get("author").getAsString();
        String description = json.get("description").getAsString();

        return new PluginInfo(main, name, version, author, description);
    }

    private static String read(InputStream inputStream) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
        {
            builder.append(line).append("\n");
        }
        reader.close();
        return builder.toString();
    }
}
